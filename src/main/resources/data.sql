

INSERT INTO marque (id, nom) VALUES (1,'Java');

INSERT INTO prix (marque_id, description, start_date, stop_date, priority, le_prix, devise ) VALUES 
(1, 'Taux standard', PARSEDATETIME('2023-06-27-17.56.00', 'yyyy-MM-dd-HH.mm.ss'), NULL, 1, 100.0, 'EUR');
