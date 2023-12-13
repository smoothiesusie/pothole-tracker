CREATE SEQUENCE inspected_date_sequence;
CREATE TABLE Inspections (
    inspectedDate INT PRIMARY KEY DEFAULT nextval('inspected_date_sequence'),
    dateInspected DATE,
    potholeID INT,
    FOREIGN KEY (potholeID) REFERENCES Potholes(PotholeID)
);


GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO final_capstone_appuser;
