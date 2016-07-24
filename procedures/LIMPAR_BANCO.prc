CREATE OR REPLACE PROCEDURE limpar_banco AS
BEGIN
  DELETE FROM sintoma;
  DELETE FROM atendimento;
  DELETE FROM hospital;
  DELETE FROM medico;
  DELETE FROM paciente;
  DELETE FROM cidade;
END limpar_banco;
/
