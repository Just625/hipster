package org.jhipster.test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.jhipster.test");

        noClasses()
            .that()
            .resideInAnyPackage("org.jhipster.test.service..")
            .or()
            .resideInAnyPackage("org.jhipster.test.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.jhipster.test.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
