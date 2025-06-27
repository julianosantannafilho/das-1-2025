package br.univille.app_a.controller;

import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// dispose = desconectar os serviços

@RestController
@RequestMapping("/api")
public class HomeController {

    //  ******** APPLICAÇÃO A  ************

    @GetMapping()
    public ResponseEntity index() {
        System.out.println("Hello from App A");
        
        try(DaprClient daprClient = new DaprClientBuilder().build()){
            daprClient.invokeMethod("app-b", "/api", null, HttpExtension.GET).block();

        } catch (Exception e){

        }

        return ResponseEntity.ok().body("Hello from App A");
    }

    @PostMapping("/startaasync")    
    public ResponseEntity startAAsync(){
        System.out.println("App A started");
        
        try(DaprClient daprClient = new DaprClientBuilder().build()) {
            var message = "será que funciona mesmo?";
            
            daprClient.publishEvent("pubsub-dapr", "topicdapr", message).block();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ResponseEntity.ok().body("App A started");

    }
}
