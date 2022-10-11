package com.protalento.market.web.controller;

import com.protalento.market.domain.Purchase;
import com.protalento.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all") // consulta todas las compras
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/consul/{idClient}") // consulta una compra con todos sus productos
    public ResponseEntity<List<Purchase>> getProductClient(@PathVariable("idClient") String idClient){
        return purchaseService.ListComprasCliente(idClient)
                .map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")// guarDA UNA COMPRA CON SUS PRODUCTOS
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }
    @PostMapping("/cslCompra/{idPurchase}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable("idPurchase") int idPurchase){
        return purchaseService.getPurchas(idPurchase)
                .map(purchase -> new ResponseEntity<>(purchase,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (purchaseService.getDelete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
