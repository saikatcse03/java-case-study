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

        assertNotNull(0, certificate);
        assertEquals(6, certificate.split(",").length);
    }

    @Test
    void whenCertificateUpdateIsCalledTwice_ReturnCallableFunctionAndValue() throws Exception {
        Callable<String> callable = certificateUpdate.getCertificateUpdate();

        String certificate1 = callable.call();
        String certificate2 = callable.call();

        assertNotNull(0, certificate1);
        assertEquals(6, certificate1.split(",").length);
        assertNotNull(0, certificate2);
        assertEquals(6, certificate2.split(",").length);

        assertNotEquals(certificate1, certificate2);
        //exact value check logic can be done with additional technique in testing
    }
}
