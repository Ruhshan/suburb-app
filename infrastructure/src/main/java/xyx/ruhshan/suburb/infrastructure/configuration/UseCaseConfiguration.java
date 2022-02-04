package xyx.ruhshan.suburb.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import xyx.ruhshan.suburb.core.location.ports.SuburbRepositoryService;
import xyx.ruhshan.suburb.core.location.usecase.SaveSuburbsUseCase;
import xyx.ruhshan.suburb.core.location.usecase.SaveSuburbsUseCaseImpl;

@Configuration
public class UseCaseConfiguration {
    private final SuburbRepositoryService suburbRepositoryService;

    public UseCaseConfiguration(SuburbRepositoryService suburbRepositoryService) {
        this.suburbRepositoryService = suburbRepositoryService;
    }

    @Bean
    public SaveSuburbsUseCaseImpl saveSuburbsUseCase() {
        return new SaveSuburbsUseCaseImpl(suburbRepositoryService);
    }

    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
