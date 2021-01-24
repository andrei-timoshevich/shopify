package com.ecommerce.shopify.service

import com.github.k0kubun.builder.query.graphql.GraphQL
import com.github.k0kubun.builder.query.graphql.builder.GraphQLObjectBuilder
import org.springframework.stereotype.Service

@Service
class GraphQLService {
    fun buildProductSearchQueryByTitle(title: String) =
        OPEN_CURLY_BRACE +
                GraphQL.createQueryBuilder()
                    .`object`(
                        PRODUCTS,
                        mapOf(QUERY to searchTemplate(title), FIRST to SEARCH_PRODUCT_LIMIT),
                        GraphQL.createObjectBuilder()
                            .`object`(
                                EDGES, GraphQL.createObjectBuilder()
                                    .`object`(
                                        NODE, GraphQL.createObjectBuilder()
                                            .field(ID)
                                            .field(TITLE)
                                            .field(TAGS)
                                            .field(PRODUCT_TYPE)
                                            .imagesQuery()
                                            .build()
                                    ).build()
                            ).build()
                    ).build() +
                CLOSE_CURLY_BRACE

    private fun GraphQLObjectBuilder.imagesQuery() =
        this.objects(
            IMAGES, SEARCH_IMAGE_LIMIT, GraphQL.createObjectBuilder()
                .`object`(
                    EDGES, GraphQL.createObjectBuilder()
                        .`object`(
                            NODE, GraphQL.createObjectBuilder()
                                .field(ID)
                                .field(ORIGINAL_SRC)
                                .build()
                        ).build()
                ).build()
        )

    companion object {
        private const val SEARCH_PRODUCT_LIMIT = 125
        private const val SEARCH_IMAGE_LIMIT = 3
        private const val EDGES = "edges"
        private const val NODE = "node"
        private const val ID = "id"
        private const val IMAGES = "images"
        private const val ORIGINAL_SRC = "originalSrc"
        private const val TAGS = "tags"
        private const val TITLE = "title"
        private const val PRODUCT_TYPE = "productType"
        private const val PRODUCTS = "products"
        private const val QUERY = "query"
        private const val FIRST = "first"
        private const val OPEN_CURLY_BRACE = "{"
        private const val CLOSE_CURLY_BRACE = "}"

        private fun searchTemplate(title: String) = "title:*$title*"
    }

}