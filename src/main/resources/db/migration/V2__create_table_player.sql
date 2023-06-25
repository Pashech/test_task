CREATE TABLE player (
    player_id INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    citizenship VARCHAR(50),
    birthPlace VARCHAR(50),
    birthDate DATE,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);