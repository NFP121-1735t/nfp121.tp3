package question1;

public class PileTest extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test PileTest
     */
    public PileTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

    public void testEncourageant(){
        assertTrue(true);
    }



	public void test_pile_Empiler() throws Exception
	{
		question1.Pile p = new question1.Pile(3);
		p.empiler(2);
		p.empiler(4);
		p.empiler(5);
		assertEquals(true, p.estPleine());
		try{
		    p.empiler(4);
		    fail();
		  }catch(Exception e ){
		      assertTrue( e instanceof PilePleineException);
		  }
	}

	public void test_pile_estVide() throws Exception
	{
		question1.Pile p = new question1.Pile(2);
		assertEquals(true, p.estVide());
		try{
		   Object o = p.depiler();
		    fail();
		  }catch( Exception e ){
		      assertTrue( e instanceof PileVideException);
		  }
	}

	public void test_pile_estPleine() throws Exception
	{
		question1.Pile p = new question1.Pile(3);
		p.empiler(3);
		p.empiler(4);
		assertEquals(false, p.estPleine());
		p.empiler(2);
		assertEquals(true, p.estPleine());
		try{
		    p.empiler(0);
		    fail();
		  }catch( Exception e){
		      assertTrue( e instanceof PilePleineException);
		  }
	}

	public void test_pile_depiler() throws Exception
	{
		question1.Pile p = new question1.Pile(2);
		p.empiler(2);
		assertEquals(false, p.estVide());
		p.empiler(4);
		assertEquals(true, p.estPleine());
		assertEquals("depiler","4", p.depiler());
		assertEquals("depiler","2", p.depiler());
		assertEquals(true, p.estVide());
		try{
		    Object o = p.depiler();
		    fail();
		  }catch ( Exception e ){
		      assertTrue( e instanceof PileVideException);
		  }
	}

	public void test_pile_toString() throws Exception
	{
		question1.Pile p = new question1.Pile(3);
		assertEquals("toString imposiible","[]", p.toString());
		p.empiler(3);
		assertEquals("toString possible","[3]", p.toString());
		p.empiler(1);
		assertEquals("toString possible","[1,3]", p.toString());
		p.empiler(5);
		assertEquals("toString possible","[5,1,3]", p.toString());
	}

	
}







