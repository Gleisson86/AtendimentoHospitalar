CREATE TRIGGER unicidade_horario_medico
BEFORE INSERT ON atendimento
FOR EACH ROW
DECLARE
  horarios atendimento.horario%TYPE;
BEGIN
  SELECT horario INTO horarios 
  FROM atendimento 
  WHERE horario = :new.horario AND atendimento.medico_id = :new.medico_id;
    
  IF horarios IS NOT NULL THEN
     RAISE_APPLICATION_ERROR(-20001, 'Horário já agendado');
  END IF;
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN;
    WHEN OTHERS THEN RAISE;
END;