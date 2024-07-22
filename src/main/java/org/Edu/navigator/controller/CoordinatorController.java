package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.RequestDto.CoordinatorRequestDto;
import org.Edu.navigator.entities.Coordinator;
import org.Edu.navigator.services.CoordinatorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("coordinator")
public class CoordinatorController {

    public final CoordinatorServices coordinatorServices;


    @PostMapping
   public ResponseEntity<String> create(@RequestBody CoordinatorRequestDto coordinator){
       coordinatorServices.create(coordinator);
       return ResponseEntity.ok("Successfully Created");
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
        return ResponseEntity.ok("Successfully Deleted");
   }

   @PutMapping("{id}")
   public ResponseEntity<String> update(@PathVariable long id,@RequestBody CoordinatorRequestDto coordinatorRequestDto){
        coordinatorServices.update(id, coordinatorRequestDto);
        return ResponseEntity.ok("Successfully Updated");
   }

}