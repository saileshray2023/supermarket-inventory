CREATE TABLE store (
                       id          BIGSERIAL PRIMARY KEY,
                       name        VARCHAR(150) NOT NULL,
                       location    VARCHAR(150) NOT NULL,
                       address     VARCHAR(300),
                       active      BOOLEAN NOT NULL DEFAULT true,
                       created_at  TIMESTAMP NOT NULL DEFAULT now(),
                       updated_at  TIMESTAMP NOT NULL DEFAULT now()
);