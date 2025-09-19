package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

public class CertificateUpdateTest {

    private final CertificateUpdate certificateUpdate = new CertificateUpdate();

    @Test
    void whenCertificateUpdateIsCalledOnce_ReturnCallableFunctionAndValue() throws Exception {
        Callable<String> callable = certificateUpdate.getCertificateUpdate();

        String certificate = callable.call();

        assertEquals(6, certificate.split(",").length);
    }

    @Test
    void whenCertificateUpdateIsCalledTwice_ReturnCallableFunctionAndValue() throws Exception {
        Callable<String> callable = certificateUpdate.getCertificateUpdate();

        String certificate1 = callable.call();
        String certificate2 = callable.call();

        assertEquals(6, certificate1.split(",").length);
        assertEquals(6, certificate2.split(",").length);

        assertNotEquals(certificate1, certificate2);
        //exact value check logic can be done with additional technique in testing
    }

    @Test
    void whenCertificateUpdateIsCalled100Times_ReturnCallableFunctionAndValue() throws Exception {
        Callable<String> callable = certificateUpdate.getCertificateUpdate();
        int count = 0;
        while(count < 100) {

            String certificate = callable.call();
            assertEquals(6, certificate.split(",").length);
            assertEquals(6, certificate.split(",").length);
            count++;
        }
        //exact value check logic can be done with additional technique in testing
    }
}
