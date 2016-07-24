CREATE OR REPLACE FUNCTION max_freq_sintoma
   RETURN VARCHAR
IS
  qtde numeric;
  nome VARCHAR(20);
BEGIN
  FOR sintomas IN
       (SELECT COUNT(*) AS qtde, nome
       FROM sintoma
       GROUP BY nome ORDER BY qtde DESC)
  LOOP
       RETURN sintomas.nome;
  END LOOP;
END;
/
