package com.cloud.config;

import com.google.gson.JsonObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
public class GatewayFilter implements GlobalFilter, Ordered {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> authorization = exchange.getRequest().getHeaders().get("authorization");
        if (Objects.nonNull(authorization) && !authorization.isEmpty()) {
            String token = authorization.get(0).replace("Bearer ","");
            if(stringRedisTemplate.hasKey(token)) {
                // 更新token过期时间
                stringRedisTemplate.opsForValue().set(token,"",30, TimeUnit.SECONDS);
                return chain.filter(exchange);
            }
        }
        return out(exchange.getResponse());
    }

    @Override
    public int getOrder() {
        return 0;
    }

    // 使用webflux输入请求信息
    private Mono<Void> out(ServerHttpResponse response) {
        JsonObject message = new JsonObject();
        message.addProperty("code", HttpStatus.UNAUTHORIZED.value());
        message.addProperty("message", "鉴权失败 " + HttpStatus.UNAUTHORIZED.getReasonPhrase());
        byte[] bytes = message.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        // 输出http响应
        return response.writeWith(Mono.just(buffer));
    }
}
