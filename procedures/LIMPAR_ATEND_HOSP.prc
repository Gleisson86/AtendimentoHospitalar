CREATE OR REPLACE PROCEDURE limpar_atend_hosp(id_hospital numeric) AS
BEGIN
  DELETE FROM sintoma WHERE atendimento_id in (SELECT id FROM atendimento WHERE hospital_id = id_hospital);
  DELETE FROM atendimento WHERE hospital_id = id_hospital;
END limpar_atend_hosp;
/
