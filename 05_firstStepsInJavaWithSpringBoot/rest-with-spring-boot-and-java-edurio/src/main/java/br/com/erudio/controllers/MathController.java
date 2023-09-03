package br.com.erudio.controllers;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationsException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
    private SimpleMath simpleMath = new SimpleMath();
 
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}") //Request mapping permite o controller lidar com as requisições com parâmetros, mapeia as requests pro método manipulador específico
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne, @PathVariable (value = "numberTwo") String numberTwo) throws Exception{

            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }

            return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
    public Double sub(
        @PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }

            return simpleMath.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/div/{numberOne}/{numberTwo}")
    public Double div(
        @PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }

            return simpleMath.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/media/{numberOne}/{numberTwo}")
    public Double media(
        @PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }

            return simpleMath.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/square/{numberOne}")
    public Double square(
        @PathVariable(value = "numberOne") String numberOne) throws Exception{

            if(!NumberConverter.isNumeric(numberOne)) {
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }

            return simpleMath.square(NumberConverter.convertToDouble(numberOne));
    }
}
