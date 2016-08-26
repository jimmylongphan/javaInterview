package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 8/25/2016.
 */
public class CoveredLengthImplTest {

    @Test
    public void testGetTotalCoveredLength() throws Exception {
        CoveredLengthImpl coveredLength = new CoveredLengthImpl();

        coveredLength.addInterval(3, 6);

        int length;
        length = coveredLength.getTotalCoveredLength();
        Assert.assertEquals(length, 3);

        coveredLength.addInterval(8,9);
        length = coveredLength.getTotalCoveredLength();
        Assert.assertEquals(length, 4);

        coveredLength.addInterval(1,5);
        length = coveredLength.getTotalCoveredLength();
        Assert.assertEquals(length, 6);
    }

}