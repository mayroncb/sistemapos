/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3construcoes.util;

import com.l3construcoes.entidades.Comodo;
import com.l3construcoes.entidades.Servico;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author paulolira
 */
public class CalcUtils {

    private final static double PERCENT_BY_FLOOR = 0.3;

    /**
     * @param allComodos
     * @return the sum of all rooms size
     */
    public static int loadAllSizeByRoom(List<Comodo> allComodos) {
        int tamanhoTotal = 0;
        for (Comodo cm : allComodos) {
            tamanhoTotal += cm.getTamMedio();
        }
        return tamanhoTotal;
    }

    /**
     * @param allServicos
     * @return sum of all services price
     */
    public static BigDecimal loadAllValuesByService(List<Servico> allServicos) {
        BigDecimal valorTotal = new BigDecimal(0);
        for (Servico sv : allServicos) {
            valorTotal = valorTotal.add(sv.getValor());
        }
        return valorTotal;
    }

    /**
     *
     * @param floors
     * @param servicesValues
     * @param size
     * @return final value of the project
     */
    public static BigDecimal calcValueOfTheProject(BigDecimal servicesValues, int size) {

        BigDecimal valueFinal = new BigDecimal(BigInteger.ONE);
        valueFinal = servicesValues.multiply(new BigDecimal(size));
        return valueFinal;
    }

    /**
     *
     * @param floors
     * @param servicesValues
     * @param size
     * @return final value of the project when floor greater than 1
     */
    public static BigDecimal calcValueOfTheProject(int floors, BigDecimal servicesValues, int size) {
        double percent = 0;
        BigDecimal temp = new BigDecimal(BigInteger.ONE);
        BigDecimal valueFinal = new BigDecimal(BigInteger.ONE);
        temp = servicesValues.multiply(new BigDecimal(size));
        valueFinal = valueFinal.add(temp);
        percent = PERCENT_BY_FLOOR * (floors - 1);
        temp = temp.multiply(new BigDecimal(percent));
        valueFinal = valueFinal.add(temp);
        valueFinal = valueFinal.setScale(2, RoundingMode.DOWN );
        return valueFinal;
    }

}
