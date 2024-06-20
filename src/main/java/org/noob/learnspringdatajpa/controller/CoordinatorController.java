package org.noob.learnspringdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.noob.learnspringdatajpa.entities.Coordinator;
import org.noob.learnspringdatajpa.services.CoordinatorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("coordinator")
public class CoordinatorController {
    public final CoordinatorServices coordinatorServices;
    @PostMapping
   public ResponseEntity<String> create(@RequestBody Coordinator coordinator){
       coordinatorServices.create(coordinator);
       return ResponseEntity.ok("Successfully Created NOOB Shit");
   }
   @GetMapping("{id}")
   public ResponseEntity<Coordinator> Get(@PathVariable long id){

        return ResponseEntity.ok(coordinatorServices.get(id));
   }
   @GetMapping("getAll")
   public ResponseEntity<List<Coordinator>> GetAll(){
        return ResponseEntity.ok(coordinatorServices.GetAll());
   }
   @DeleteMapping("{id}")
   public ResponseEntity<String> delete(@PathVariable  long id){
       coordinatorServices.delete(id);
        return ResponseEntity.ok("Successfully Deleted NOOB");
   }


}