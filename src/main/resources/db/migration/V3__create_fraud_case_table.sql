CREATE TABLE fraud_case (
                            case_id VARCHAR(36) PRIMARY KEY,
                            alert_id VARCHAR(36),
                            investigator VARCHAR(100),
                            status VARCHAR(30),
                            created_date TIMESTAMP,

                            CONSTRAINT fk_case_alert
                            FOREIGN KEY (alert_id)
                            REFERENCES fraud_alert(alert_id)
);