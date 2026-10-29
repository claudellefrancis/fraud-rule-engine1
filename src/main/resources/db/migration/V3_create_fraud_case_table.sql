CREATE TABLE fraud_case (
                            case_id VARCHAR(36) PRIMARY KEY,
                            investigator VARCHAR(100),
                            status VARCHAR(30),
                            created_date TIMESTAMP
);