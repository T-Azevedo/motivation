package com.azevedo.motivation.data

import com.azevedo.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val infinity = MotivationConstants.FILTER.INFINITY
    private val smile = MotivationConstants.FILTER.SMILE
    private val sun = MotivationConstants.FILTER.SUN

    private val mlistPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", smile),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile),
        Phrase("Quando está mais escuro, vemos mais estrelas!", smile),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sun),
        Phrase("Você perde todas as chances que você não aproveita.", sun),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sun),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sun),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sun),
        Phrase("Se você acredita, faz toda a diferença.", sun),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sun)

    )

    fun getPhrase(value: Int): String{

        val filtered = mlistPhrase.filter{it.categoryId == value  || value == infinity}

        return filtered[Random.nextInt(filtered.size)].description
    }

}