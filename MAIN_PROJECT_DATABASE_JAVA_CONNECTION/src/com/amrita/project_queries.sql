
USE crop_prediction_based_on_soil_nutrient_estimation;


CREATE TABLE credentials(
    username varchar(50),
    password varchar(20)
);

INSERT INTO credentials values ('personx','unanimous');

alter table credentials add primary key(username);

drop table district;

CREATE TABLE State (
    State_id int NOT NULL,
    State_Name VARCHAR(25) NOT NULL,
    No_of_districts int,
    PRIMARY KEY (State_id)
);

CREATE TABLE District (
    District_id int NOT NULL,
    District_Name VARCHAR(25) NOT NULL,
    No_of_mandals int,
    State_id int NOT NULL,
    PRIMARY KEY (District_id),
    FOREIGN KEY (State_id) REFERENCES State(State_id)
);

CREATE TABLE Mandal (
    Mandal_id int NOT NULL,
    District_id int NOT NULL,
    Mandal_Name VARCHAR(25) NOT NULL,
    No_of_farming_areas int,
    Representative VARCHAR(25),
    PRIMARY KEY (Mandal_id),
    FOREIGN KEY (District_id) REFERENCES District(District_id)
);

CREATE TABLE Area (
    Area_id int NOT NULL,
    Area_Name VARCHAR(25) NOT NULL,
    Helpline VARCHAR(20),
    Mandal_id int NOT NULL,
    PRIMARY KEY (Area_id),
    FOREIGN KEY (Mandal_id) REFERENCES Mandal(Mandal_id)
);

CREATE TABLE Weather (
    Weather_id int NOT NULL,
    Weather_Name VARCHAR(25) NOT NULL,
    Prevail VARCHAR(25),
    Chances int,
    PRIMARY KEY (Weather_id)
);

CREATE TABLE Seeds (
    Seed_id int NOT NULL,
    Seed_Name VARCHAR(25) NOT NULL,
    Seed_cost int,
    PRIMARY KEY (Seed_id)
);

CREATE TABLE WaterRes (
    WaterRes_Name VARCHAR(25) NOT NULL,
    Resource_dependency int,
    PRIMARY KEY (WaterRes_Name)
);

CREATE TABLE Rainfall (
    Rainfall_type VARCHAR(25) NOT NULL,
    Intensity int,
    Rainfall_dependency int,
    PRIMARY KEY (Rainfall_type)
);

CREATE TABLE Irrigation (
    Irrigation_Name VARCHAR(25) NOT NULL,
    Irr_efficiency int,
    Irr_cost int,
    PRIMARY KEY (Irrigation_Name)
);

CREATE TABLE Nutrients (
    Nutrient_id int NOT NULL,
    Nutrient_Name VARCHAR(25) NOT NULL,
    Nutrient_Class VARCHAR(25),
    PRIMARY KEY (Nutrient_id)
);

CREATE TABLE Farming (
    Area_id int NOT NULL,
    Farming_method VARCHAR(25) NOT NULL,
    Efficiency int,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id)
);

CREATE TABLE Soil_Nutrients (
    Area_id int NOT NULL,
    Nutrient_id int NOT NULL,
    Act_Req_percent int,
    Avail_percent int,
    Req_percent int,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (Nutrient_id) REFERENCES Nutrients(Nutrient_id)
);

CREATE TABLE Area_Irrigation (
    Area_id int NOT NULL,
    Irrigation_Name VARCHAR(25) NOT NULL,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (Irrigation_Name) REFERENCES Irrigation(Irrigation_Name)
);

CREATE TABLE Area_Rainfall (
    Area_id int NOT NULL,
    Rainfall_type VARCHAR(25) NOT NULL,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (Rainfall_type) REFERENCES Rainfall(Rainfall_type)
);

CREATE TABLE Area_WaterResource (
    Area_id int NOT NULL,
    WaterRes_Name VARCHAR(25) NOT NULL,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (WaterRes_Name) REFERENCES WaterRes(WaterRes_Name)
);

CREATE TABLE Area_Seed (
    Area_id int NOT NULL,
    Seed_id int NOT NULL,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (Seed_id) REFERENCES Seeds(Seed_id)
);

CREATE TABLE Area_Weather (
    Area_id int NOT NULL,
    Weather_id int NOT NULL,
    FOREIGN KEY (Area_id) REFERENCES Area(Area_id),
    FOREIGN KEY (Weather_id) REFERENCES Weather(Weather_id)
);

select * from State;

INSERT INTO State VALUES (1, 'Andhra Pradesh',13 );
INSERT INTO State VALUES (2, 'Telangana',33);
INSERT INTO State VALUES (3, 'Tamil nadu',38);

INSERT INTO District VALUES (11, 'Chittoor',66 , 1);
INSERT INTO District VALUES (12, 'Adilabad', 52, 2);
INSERT INTO District VALUES (13, 'Coimbatore', 11, 3);

INSERT INTO Mandal VALUES (101,11, 'Bangarupalem',50, 'Sharma');
INSERT INTO Mandal VALUES (112,12, 'Mandamarri',34, 'Srinivas');
INSERT INTO Mandal VALUES (132,13, 'Madukkarai',54, 'Sunil Shetty');

INSERT INTO Area VALUES (1001, 'Gollapalle', '9849562345', 101);
INSERT INTO Area VALUES (1112, 'Andgulapet', '9679565445', 112);
INSERT INTO Area VALUES (1325, 'Nachipalayam', '9542689758', 132);

INSERT INTO Weather VALUES (41, 'Rainy', 'jul,Aug,sept', 98);
INSERT INTO Weather VALUES (42, 'Sunny', 'Mar,Apr,may', 96);
INSERT INTO Weather VALUES (43, 'Cloudy', 'jun,', 65);
INSERT INTO Weather VALUES (44, 'Partially cloudy', 'jan, feb',30);

INSERT INTO Seeds VALUES (60, 'cotton', 450);
INSERT INTO Seeds VALUES (61, 'Sunflower', 350);
INSERT INTO Seeds VALUES (62, 'Tomato', 500);

INSERT INTO WaterRes VALUES ('Rain', 86);
INSERT INTO WaterRes VALUES ('River', 65);
INSERT INTO WaterRes VALUES ('canal', 56);

INSERT INTO Rainfall VALUES ('Conventional', 80, 73);
INSERT INTO Rainfall VALUES ('Orographic', 40, 61);
INSERT INTO Rainfall VALUES ('Frontal', 53, 33);

INSERT INTO Irrigation VALUES ('Drip', 90, 10000);
INSERT INTO Irrigation VALUES ('Sprinkler', 75, 9500);
INSERT INTO Irrigation VALUES ('Surface', 60, 5000);

INSERT INTO Nutrients VALUES (80, 'Phosphorus', 'macro');
INSERT INTO Nutrients VALUES (81, 'Nitrogen', 'macro');
INSERT INTO Nutrients VALUES (82, 'Iron', 'micro');

INSERT INTO Farming VALUES (1001, 'Mixed Farming', 75);
INSERT INTO Farming VALUES (1112, 'Subsistence Farming', 67);
INSERT INTO Farming VALUES (1325, 'Commercial Farming.', 83);

INSERT INTO Soil_Nutrients VALUES (1001, 80,73,37,36);
INSERT INTO Soil_Nutrients VALUES (1112, 81,42,21,21 );
INSERT INTO Soil_Nutrients VALUES (1325, 82, 37,16,21);

INSERT INTO Area_Irrigation VALUES (1001, 'Surface');
INSERT INTO Area_Irrigation VALUES (1112, 'Drip');
INSERT INTO Area_Irrigation VALUES (1325, 'Sprinkler');

INSERT INTO Area_Rainfall VALUES (1001, 'Conventional');
INSERT INTO Area_Rainfall VALUES (1112, 'Frontal');
INSERT INTO Area_Rainfall VALUES (1325, 'Orographic');

INSERT INTO Area_WaterResource VALUES (1001, 'Rain');
INSERT INTO Area_WaterResource VALUES (1112, 'canal');
INSERT INTO Area_WaterResource VALUES (1325, 'River');

INSERT INTO Area_Seed VALUES (1001, 62);
INSERT INTO Area_Seed VALUES (1112, 60);
INSERT INTO Area_Seed VALUES (1325, 61);

INSERT INTO Area_Weather VALUES (1001, 44);
INSERT INTO Area_Weather VALUES (1112, 42);
INSERT INTO Area_Weather VALUES (1325, 41);








