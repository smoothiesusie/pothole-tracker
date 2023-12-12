CREATE TABLE Potholes (
    PotholeID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,  -- Foreign key to Users table
    Latitude DECIMAL(10, 8),
    Longitude DECIMAL(11, 8),
    Description TEXT,
    Status VARCHAR(50),
    ReportedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(user_id)
);