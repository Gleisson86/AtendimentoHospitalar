CREATE TRIGGER atend_fora_horario
BEFORE INSERT ON atendimento
FOR EACH ROW
DECLARE
  hora_atendimento numeric;
BEGIN
  hora_atendimento := TO_NUMBER(TO_CHAR(:new.horario,'HH24MI'));
  
  IF hora_atendimento < 600 THEN
     RAISE_APPLICATION_ERROR(-20001, 'Horário indisponível');
  END IF;
  
  IF hora_atendimento > 2200 THEN
     RAISE_APPLICATION_ERROR(-20001, 'Horário indisponível');
  END IF;
END;
