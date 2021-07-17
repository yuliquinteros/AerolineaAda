package com.ada.aerolineaf.aerolineaV1.controller;

import com.ada.aerolineaf.aerolineaV1.model.*;
import com.ada.aerolineaf.aerolineaV1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aerolineaf/ada/v1")
public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private FlightRepository flightRepository;

    // ==================READ===============

    @GetMapping(path = "/base/all")
    public @ResponseBody
    Iterable<Base> getAllBases() {
        return baseRepository.findAll();
    }


    @GetMapping(path = "/base/{id_base}") //path es la ruta la colita del "url" base (toda la url se llama "endpoint"
    public @ResponseBody
    ResponseEntity<BaseResponse> getAllBaseById(@PathVariable int id_base) { // ResponseEntity entidad de respuesta de nuestras peticiones
        //tiene una base y un mensaje. Es lo q en el post nos sale id provincia etc
        BaseResponse response = new BaseResponse(); //instanciamos una respuesta
        try {
            response.setBase(baseRepository.findById(id_base).get()); //le seteamos una base, find es lo q va a buscar y encontrar
            response.setMessage("Ok!"); // si encontro lo q buscaba le manda este mensaje
            return ResponseEntity.ok(response); // y muestra esto
        } catch (Exception e) { //nos preparamos por si aparece alguna excepcion/error
            response.setBase(baseRepository.findById(1).get());
            response.setMessage("Id base no encontrado : "  + e.getMessage() + "---" + e.getClass());
            return ResponseEntity.badRequest().body(response); // muestro la expecion y le digo q me diga cual es el error
        }

    }


    @GetMapping(path = "/pilot/all")
    public @ResponseBody
    Iterable<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }

    @GetMapping(path = "/pilot/{id}")
    public @ResponseBody
    Optional<Pilot> getPilotByID(@PathVariable("id") int id) {
        return pilotRepository.findById(id);
    }

    @GetMapping(path = "/airplane/all")
    public @ResponseBody
    Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @GetMapping(path = "/airplane/{id}")
    public @ResponseBody
    Optional<Airplane> getAllAirplaneById(@PathVariable("id") int id) {
        return airplaneRepository.findById(id);
    }

    @GetMapping(path = "/crew/all")
    public @ResponseBody
    Iterable<Crew> getAllCrew() {
        return crewRepository.findAll();
    }

    @GetMapping(path = "/flight/all")
    public @ResponseBody
    Iterable<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

// ====================CUSTOM QUERIES==================

    @GetMapping(path = "/base/city/like/{city}")
    public @ResponseBody
    Iterable<Base> getBaseByNameLike(@PathVariable("city") String city) {
        return baseRepository.getBasesByCityLike(city);
    }

    @GetMapping(path = "/flight/city/like/{city}")
    public @ResponseBody
    Iterable<Flight> getFlightByOriginLike(@PathVariable("city") String city) {
        return flightRepository.getFlightsByOriginOrDestinationLike(city);
    }

    @GetMapping(path = "/flight/date/{year}/{month}/city/like/{city}")
    public @ResponseBody
    Iterable<Flight> getFlightByDateAndCity(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("city") String city) {
        return flightRepository.getFlightsByDate(year, month, city);
    }



    // ====================CREATE==================
    // ya no uso GET si no POSTmapping porque esa es la manera de CREAR en postman
    @PostMapping(path = "/base/create", consumes =  "application/json", produces = "application/json")
    // "path" es una partecita de la url, la colita
    public Base createBase(@RequestBody Base newBase) {
        // el RequestBody lo tengo que usar para q en postman se interprete lo q se agrega en el body del postman
        return baseRepository.save(newBase);
        }

    @PostMapping(path = "/pilot/create", consumes =  "application/json", produces = "application/json")
    public Pilot createPilot(@RequestBody Pilot newPilot) {
        return pilotRepository.save(newPilot);
    }

    @PostMapping(path = "/airplane/create", consumes =  "application/json", produces = "application/json")
    public Airplane createAirplane(@RequestBody Airplane newAirplane) {
        return airplaneRepository.save(newAirplane);
    }

    // ===========UPDATE===========

    @PutMapping(path = "/base/update")
    public Base updateBase(@RequestBody Base updateBase) {

        return baseRepository.save(updateBase);
    }

    @PutMapping(path = "/pilot/update")
    public Pilot updatePilot(@RequestBody Pilot updatePilot) {

        return pilotRepository.save(updatePilot);
    }

    @PutMapping(path = "/pilot/{id}/update/base/{id_base}")
    public Pilot updatePilot(@PathVariable("id") int id, @PathVariable("id_base") int id_base) {
        Pilot pilot = pilotRepository.findById(id).get();
        Base base = baseRepository.findById(id_base).get();

        pilot.setBase(base);
        pilotRepository.save(pilot);

        return pilot;
    }
// =====================DELETE====================

    @DeleteMapping(path = "/base/delete/{id_base}")
    public @ResponseBody
    Iterable<Base> deleteBaseById(@PathVariable("id_base") int id_base) {
        baseRepository.deleteById(id_base);
        return baseRepository.findAll();
    }
    @DeleteMapping(path = "/base/delete2/{id_base}")
    public @ResponseBody
    String deleteBaseById2(@PathVariable("id_base") int id_base) {
        baseRepository.deleteById(id_base);
        return "El registro fue eliminado, id : " + id_base;
    }

    @DeleteMapping(path = "/pilot/delete/{id}")
    public @ResponseBody
    Iterable<Pilot> deletePilotById(@PathVariable("id") int id) {
        pilotRepository.deleteById(id);
        return pilotRepository.findAll();
    }


}
