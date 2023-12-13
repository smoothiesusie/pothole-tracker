CREATE SEQUENCE inspected_date_sequence;
CREATE TABLE Inspections (
    inspectedDate INT PRIMARY KEY DEFAULT nextval('inspected_date_sequence'),
    dateInspected DATE,
    potholeID INT,
    FOREIGN KEY (potholeID) REFERENCES Potholes(PotholeID)
);