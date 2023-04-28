package com.example.springbatchkafka.config;

import com.example.springbatchkafka.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@StepScope
@Slf4j
public class CustomItemProcessor implements ItemProcessor<TestEntity, TestEntity> {
    @Override
    public TestEntity process(TestEntity entity) {
        log.info("Processing result : {}", entity.toString());
        return entity;
    }
}
