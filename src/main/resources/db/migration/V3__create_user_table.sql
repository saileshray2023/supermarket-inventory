CREATE TABLE app_user (
                          id            BIGSERIAL PRIMARY KEY,
                          username      VARCHAR(50) NOT NULL,
                          email         VARCHAR(150) NOT NULL,
                          password_hash VARCHAR(255) NOT NULL,
                          full_name     VARCHAR(150) NOT NULL,
                          role          VARCHAR(20) NOT NULL,
                          active        BOOLEAN NOT NULL DEFAULT true,
                          created_at    TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at    TIMESTAMP NOT NULL DEFAULT now(),

                          CONSTRAINT uq_user_username UNIQUE (username),
                          CONSTRAINT uq_user_email UNIQUE (email)
);