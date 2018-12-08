/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aga.Krypto;

/**
 *
 * @author emate
 */
interface Algorithm {
    public StringBuilder crypt(StringBuilder word);
    public StringBuilder encrypt(StringBuilder word);
}
