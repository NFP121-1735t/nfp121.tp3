package question2;

/**
 * Classe-test Pile3Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile3Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private PileI p1;
    private PileI p2;
    /**
     * Constructeur de la classe-test Pile3Test
     */
    

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        p1 = new question2.Pile3();
        p2 = new question2.Pile3();

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


	public void test_pile3_capacite()
	{
		assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
	}

	public void test_pile3_estPleine() throws Exception {
        question2.Pile3 p = new question2.Pile3(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }



	public void test_pile3_sommet() throws Exception
	{
		question2.Pile3 p = new question2.Pile3(3);
		assertEquals(true, p.estVide());
		p.empiler(new Integer(3));
		assertEquals("sommet", new Integer(3), p.sommet());
		assertEquals(1, p.taille());
		assertEquals("depiler", new Integer(3), p.depiler());
		assertEquals(0, p.taille());
	}
	 public void test_pile3_estVide() throws Exception {
       question2.Pile3 p = new question2.Pile3(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
public void test_pile3_toString() throws Exception {
        question2.Pile3 Pile31 = new question2.Pile3(3);
        assertEquals("toString impossible ", "[]", Pile31.toString());
        Pile31.empiler(4);
        assertEquals("toString possible ", "[4]", Pile31.toString());
        Pile31.empiler(5);
        assertEquals("toString possible ", "[5, 4]", Pile31.toString());
        Pile31.empiler(3);
        assertEquals("toString possible ", "[3, 5, 4]", Pile31.toString());

    }

	public void test_pile3_equals() throws Exception
	{
		p1.empiler(1);
		p1.empiler(3);
		p1.empiler(4);
		p2.empiler(4);
		p2.empiler(1);
		p2.empiler(2);
		assertTrue("egalite de deux piles true", p1.equals(p2));
		assertTrue("egalite de deux piles true", p2.equals(p1));
		assertTrue("egalite de deux piles true", p2.equals(p2));
		p1.empiler(2);
		assertFalse("egalite de deux piles false", p1.equals(p2));
	}

	public void test_pile3_tailleNegative()
	{
		question2.Pile3 ppp = new question2.Pile3(-5);
		assertEquals(ppp.CAPACITE_PAR_DEFAUT, ppp.capacite());
	}
}







