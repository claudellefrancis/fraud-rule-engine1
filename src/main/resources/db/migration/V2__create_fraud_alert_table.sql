CREATE TABLE fraud_alert (
                             alert_id VARCHAR(36) PRIMARY KEY,
                             event_id VARCHAR(36),
                             alert_type VARCHAR(50),
                             rule_triggered VARCHAR(100),
                             risk_level VARCHAR(20),
                             status VARCHAR(20),
                             alert_date TIMESTAMP,

                             CONSTRAINT fk_alert_event
                                 FOREIGN KEY (event_id)
                                     REFERENCES fraud_event(event_id)
);