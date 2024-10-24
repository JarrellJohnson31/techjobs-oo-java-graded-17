package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());


    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job();
        String jobString = job.toString();

        assertTrue(jobString.startsWith(System.lineSeparator()));
        assertTrue(jobString.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        String expectedJobString = System.lineSeparator()
                + "ID: " + job.getId() + System.lineSeparator()
                + "Name: " + job.getName() + System.lineSeparator()
                + "Employer: "  + job.getEmployer().getValue() + System.lineSeparator()
                + "Location: "  + job.getLocation().getValue() + System.lineSeparator()
                + "Position Type: "  + job.getPositionType().getValue() + System.lineSeparator()
                + "Core Competency: "  + job.getCoreCompetency().getValue()
                + System.lineSeparator();
        assertEquals(jobString,expectedJobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();
        String expectedJobString = System.lineSeparator()
                + "ID: " + job.getId() + System.lineSeparator()
                + "Name: Data not available" + System.lineSeparator()
                + "Employer: Data not available" + System.lineSeparator()
                + "Location: Data not available" + System.lineSeparator()
                + "Position Type: Data not available" + System.lineSeparator()
                + "Core Competency: Data not available"
                + System.lineSeparator();
        assertEquals(expectedJobString,jobString);
    }
}
