CREATE TABLE products (
                          categoryId BIGSERIAL PRIMARY KEY,
                          categoryName VARCHAR(255) NOT NULL,
                          categoryDescription VARCHAR(255) NOT NULL
);