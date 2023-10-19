@CardPayment
Feature: Card Payment

  Background:
    Given el servicio CardPayment


  @PCP-17860
  Scenario: Card Payment/Consult Payment ok
    Given una card para consulta
    Then the status code should be