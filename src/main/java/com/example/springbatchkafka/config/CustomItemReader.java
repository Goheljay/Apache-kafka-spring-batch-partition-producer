package com.example.springbatchkafka.config;

import com.example.springbatchkafka.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class CustomItemReader extends JdbcCursorItemReader<TestEntity> implements ItemReader<TestEntity> {
    public CustomItemReader(@Autowired DataSource primaryDataSource) {
        setDataSource(primaryDataSource);
        setSql("SELECT * FROM test_entity");
        setFetchSize(100);
        setRowMapper(new EmployeeRowMapper());
    }

    public static class EmployeeRowMapper implements RowMapper<TestEntity> {
        @Override
        public TestEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            TestEntity employee  = new TestEntity();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("firstname"));
            employee.setDate(rs.getDate("joined"));
            return employee;
        }

    }
}
