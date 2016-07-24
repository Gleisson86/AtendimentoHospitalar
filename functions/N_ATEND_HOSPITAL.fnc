CREATE OR REPLACE FUNCTION n_atend_hospital(id_hospital NUMERIC)
   RETURN NUMERIC
IS
   n_atends NUMERIC;
BEGIN
  SELECT COUNT(*) 
    INTO n_atends 
    FROM atendimento a WHERE a.hospital_id = id_hospital;

  RETURN n_atends;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20001, 'Hospital não possui atendimentos registrados!');
    WHEN OTHERS THEN RAISE;
END;
/
