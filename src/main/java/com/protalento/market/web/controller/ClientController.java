package com.protalento.market.web.controller;

import com.protalento.market.domain.Client;
import com.protalento.market.domain.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// le indica a spring que esto va hacer un controlador de una api rest
@RequestMapping("/client")// indica el path en la cual podemos hacer las peticiones a nuestra api
public class ClientController {

    @Autowired // le delegamos a spring la inyeccion de la depencencia
    private ClientService clientService;

    @GetMapping("/all")
    @ApiOperation("muestra todos los clientes y sus compras ")
    @ApiResponse(code = 200,message = "Ok")
    public ResponseEntity<List<Client>>getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("consuta/cliente/{idCliente}")
    @ApiOperation("consulta un cliente por su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not_Found")
    })
    public ResponseEntity<Client> getClient(@ApiParam(value = "Recibe un idCliente de tipo String",required = true,example = "4546221") @PathVariable("idCliente") String idCliente){
        return clientService.getCliente(idCliente)
                .map( client -> new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("guarda un cliente y sera recibido a traves del body")
    @ApiResponse(code = 201, message ="Create")
    public ResponseEntity<Client> guardar(@ApiParam(value = "resibe un objeto de tipo Cliente",required = true)@RequestBody Client client){
        return new ResponseEntity<>(clientService.getSave(client),HttpStatus.CREATED);
    }


/*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity getDelete(@PathVariable("id")  String  id){
        if(clientService.getEliminar(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
*/

}
