package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BlackJackDeckTest {
    @Test
    fun `카드는 에이스(1,11)부터 2~10 JACK(10) QUEEN(10) KING(10)이 있다`() {
        val blackJackCard =
            BlackJackDeck(mutableListOf(BlackJackCard.get(BlackJackCardShape.HEART, BlackJackCardNumber.ACE))).draw()
        assertThat(blackJackCard.number.values).containsExactly(1, 11)
        assertThat(blackJackCard.shape).isEqualTo(BlackJackCardShape.HEART)
    }

    @Test
    fun `중복된 카드는 지급될수 없다`() {
        val blackJackDeck =
            BlackJackDeck(mutableListOf(BlackJackCard.get(BlackJackCardShape.HEART, BlackJackCardNumber.ACE)))
        blackJackDeck.draw()
        assertThatThrownBy { blackJackDeck.draw() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("카드가 없어요")
    }
}
