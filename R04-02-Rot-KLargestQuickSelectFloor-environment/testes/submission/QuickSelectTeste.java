package submission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderStatistic.QuickSelect;

class QuickSelectTeste {

	private QuickSelect<Integer> implementacao;
    private Integer[] array;
    
    @BeforeEach
    public void setUp() {
    	this.implementacao = new QuickSelect<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }
    
    @Test
    public void testQuickSelect01() {
        assertEquals(this.implementacao.quickSelect(this.array, 1), (Integer) 4);
    }

    @Test
    public void testQuickSelect02() {
        assertEquals(this.implementacao.quickSelect(this.array, 2), (Integer) 7);
    }

    @Test
    public void testQuickSelect03() {
        assertEquals(this.implementacao.quickSelect(this.array, 5), (Integer) 23);
    }

    // Teste com array nulo
    @Test
    public void testQuickSelect04() {
        assertEquals(this.implementacao.quickSelect(null, 5), null);
    }

    // Teste com k > tamanho do array
    @Test
    public void testQuickSelect05() {
        assertEquals(this.implementacao.quickSelect((this.array), 11), null);
    }

    // Teste com k < 0
    @Test
    public void testQuickSelect06() {
        assertEquals(this.implementacao.quickSelect((this.array), -1), null);
    }

    // Teste com array vazio
    @Test
    public void testQuickSelect07() {
        assertEquals(this.implementacao.quickSelect(new Integer[] {}, 5), null);
    }

}
