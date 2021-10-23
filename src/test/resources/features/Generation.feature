Feature: Código de respuesta de solicitud GET
  Como automatizador de pruebas de un servicio rest
  necesito validar que servicio este haciendo el llamado
  para asegurar los datos son exactos

  Background:
    Given que el automatizador hace un peticion get

  Scenario: Validar el codigo del servicio ok
    Given que el automatizador hace un peticion get
    When la api hace el llamado del servicio
    Then ela respuesta es exitosa ok

  Scenario: Validar la respuesta de datos nombre y url
    When se hace la petición get
    Then arroja el nombre y url de resultado