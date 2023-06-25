CREATE TABLE players (
                         player_id INT PRIMARY KEY,
                         first_name VARCHAR(50),
                         last_name VARCHAR(50),
                         citizenship VARCHAR(50),
                         birth_place VARCHAR(50),
                         birth_date DATE,
                         team_id INT,
                         FOREIGN KEY (team_id) REFERENCES teams(team_id)
);