package com.ibtech.microservices.neo4j.data;


import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

@Service
public class DataInitService {

    private Session session;

    @Autowired
    public DataInitService(Session session) {
        this.session = session;
    }

    @Transactional
    public void clearDatabase() {
        session.purgeDatabase();
    }

    @Transactional
    public void load() {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("script.cql")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String cqlFile = sb.toString();
        session.query(cqlFile, Collections.EMPTY_MAP);
    }

}

