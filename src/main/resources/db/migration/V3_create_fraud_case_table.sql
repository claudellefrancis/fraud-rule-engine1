CREATE TABLE fraud_case (
                            case_id UUID PRIMARY KEY,
                            investigator VARCHAR(100),
                            status VARCHAR(30),
                            created_date TIMESTAMP
);