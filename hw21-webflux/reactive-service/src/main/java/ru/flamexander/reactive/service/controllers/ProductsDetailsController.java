package ru.flamexander.reactive.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.flamexander.reactive.service.dtos.ProductDetailsDto;
import ru.flamexander.reactive.service.dtos.DetailedProductDto;
import ru.flamexander.reactive.service.entities.Product;
import ru.flamexander.reactive.service.services.ProductDetailsService;
import ru.flamexander.reactive.service.services.ProductsService;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/detailed")
@RequiredArgsConstructor
public class ProductsDetailsController {
    private final ProductDetailsService productDetailsService;
    private final ProductsService productsService;

    public Mono<DetailedProductDto> mapToDetailedProductDto(Mono<ProductDetailsDto> productDetailsDtoMono, Mono<Product> productMono) {
        return Mono.zip(productDetailsDtoMono, productMono)
                .map(tuple -> {
                    ProductDetailsDto productDetailsDto = tuple.getT1();
                    Product product = tuple.getT2();

                    DetailedProductDto detailedProductDto = new DetailedProductDto();
                    detailedProductDto.setId(product.getId());
                    detailedProductDto.setName(product.getName());
                    detailedProductDto.setDescription(productDetailsDto.getDescription());

                    return detailedProductDto;
                });
    }


    public Flux<DetailedProductDto> getDetailedProductDtoList(Flux<Product> productFlux) {
        return productFlux.flatMap(product -> {
            Mono<ProductDetailsDto> productDetailsDtoMono = productDetailsService.getProductDetailsById(product.getId());

            return productDetailsDtoMono.map(productDetailsDto -> {
                DetailedProductDto detailedProductDto = new DetailedProductDto();
                detailedProductDto.setId(product.getId());
                detailedProductDto.setName(product.getName());
                detailedProductDto.setDescription(productDetailsDto.getDescription());

                return detailedProductDto;
            });
        }).collectList().flatMapMany(Flux::fromIterable);
    }

    @GetMapping("/demo")
    public Flux<ProductDetailsDto> getManySlowProducts() {
        Mono<ProductDetailsDto> p1 = productDetailsService.getProductDetailsById(1L);
        Mono<ProductDetailsDto> p2 = productDetailsService.getProductDetailsById(2L);
        Mono<ProductDetailsDto> p3 = productDetailsService.getProductDetailsById(3L);
        return p1.mergeWith(p2).mergeWith(p3);
    }

    @GetMapping("/all")
    public Flux<DetailedProductDto> getAllProductDetails() {
        Flux<Product> monoProduct = productsService.findAll();
        return getDetailedProductDtoList(monoProduct);
    }

    @GetMapping("/{id}")
    public Flux<DetailedProductDto> getMonoProductDetails(@PathVariable String id) {
        List<String> listId = Arrays.asList(id.split("\\s*,\\s*")).stream().distinct().toList();
        Mono<DetailedProductDto> monoDetailedProductDto;
        Mono<List<DetailedProductDto>> monoListDetailedProductDto;
        Flux<DetailedProductDto> fluxDetailedProductDto = Flux.empty();
        for (int i = 0; i < listId.size(); i++
        ) {
            Long longId = Long.valueOf(listId.get(i).toString());
            Mono<ProductDetailsDto> monoProductDetail = productDetailsService.getProductDetailsById(longId);
            Mono<Product> monoProduct = productsService.findById(longId);
            monoDetailedProductDto = mapToDetailedProductDto(monoProductDetail, monoProduct);
            fluxDetailedProductDto = fluxDetailedProductDto.concatWith(monoDetailedProductDto.flux());
        }

        return fluxDetailedProductDto;
    }
}