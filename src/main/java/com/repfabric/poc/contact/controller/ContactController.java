package com.repfabric.poc.contact.controller;

import com.repfabric.poc.contact.repository.ContactRepository;
import com.repfabric.poc.contact.service.ContactService;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.controller.errors.BadRequestAlertException;
import com.repfabric.poc.contact.utils.HeaderUtil;
import com.repfabric.poc.contact.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing
 * {@link com.rebfabric.poc.contact.domain.Contact}.
 */
@RestController
@RequestMapping("/api")
public class ContactController {

    private final Logger log = LoggerFactory.getLogger(ContactController.class);

    private static final String ENTITY_NAME = "repfabricContactContact";

    private final String applicationName = "POC Contact";

    private final ContactService contactService;

    private final ContactRepository contactRepository;

    public ContactController(ContactService contactService, ContactRepository contactRepository) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
    }

    /**
     * {@code POST  /contacts} : Create a new contact.
     *
     * @param contactDTO the contactDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and
     * with body the new contactDTO, or with status {@code 400 (Bad Request)} if
     * the contact has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/contacts")
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = ContactDTO.class))},
                description = "OK",
                responseCode = "200")})
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) throws URISyntaxException {
        log.debug("REST request to save Contact : {}", contactDTO);
        if (contactDTO.getId() != null) {
            throw new BadRequestAlertException("A new contact cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ContactDTO result = contactService.save(contactDTO);
        return ResponseEntity
                .created(new URI("/api/contacts/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /contacts/:id} : Updates an existing contact.
     *
     * @param id the id of the contactDTO to save.
     * @param contactDTO the contactDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated contactDTO, or with status {@code 400 (Bad Request)} if
     * the contactDTO is not valid, or with status
     * {@code 500 (Internal Server Error)} if the contactDTO couldn't be
     * updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/contacts/{id}")
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = ContactDTO.class))},
                description = "OK",
                responseCode = "200")})
    public ResponseEntity<ContactDTO> updateContact(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ContactDTO contactDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Contact : {}, {}", id, contactDTO);
        if (contactDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, contactDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!contactRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ContactDTO result = contactService.update(contactDTO);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, contactDTO.getId().toString()))
                .body(result);
    }

    /**
     * {@code PATCH  /contacts/:id} : Partial updates given fields of an existing
     * contact, field will ignore if it is null
     *
     * @param id the id of the contactDTO to save.
     * @param contactDTO the contactDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated contactDTO, or with status {@code 400 (Bad Request)} if
     * the contactDTO is not valid, or with status {@code 404 (Not Found)} if
     * the contactDTO is not found, or with status
     * {@code 500 (Internal Server Error)} if the contactDTO couldn't be
     * updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/contacts/{id}", consumes = {"application/json", "application/merge-patch+json"})
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = ContactDTO.class))},
                description = "OK",
                responseCode = "200")})
    public ResponseEntity<ContactDTO> partialUpdateContact(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ContactDTO contactDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Contact partially : {}, {}", id, contactDTO);
        if (contactDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, contactDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!contactRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ContactDTO> result = contactService.partialUpdate(contactDTO);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, contactDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /contacts} : get all the contacts.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the
     * list of contacts in body.
     */
    @GetMapping("/contacts")
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    array = @ArraySchema(schema = @Schema(implementation = ContactDTO.class)))},
                description = "OK",
                responseCode = "200")})
    public List<ContactDTO> getAllContacts() {
        log.debug("REST request to get all Contacts");
        return contactService.findAll();
    }

    /**
     * {@code GET  /contacts/:id} : get the "id" contact.
     *
     * @param id the id of the contactDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the contactDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/contacts/{id}")
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = ContactDTO.class))},
                description = "OK",
                responseCode = "200")})
    public ResponseEntity<ContactDTO> getContact(@PathVariable Long id) {
        log.debug("REST request to get Contact : {}", id);
        Optional<ContactDTO> contactDTO = contactService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contactDTO);
    }

    /**
     * {@code DELETE  /contacts/:id} : delete the "id" contact.
     *
     * @param id the id of the contactDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/contacts/{id}")
    @ApiResponses(value = {
        @ApiResponse(content = {
            @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = String.class))},
                description = "OK",
                responseCode = "200")})
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        log.debug("REST request to delete Contact : {}", id);
        contactService.delete(id);
        Optional<String> answer = Optional.of("deleted");
        return ResponseUtil.wrapOrNotFound(
                answer,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, id.toString()));
        /*return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();*/
    }
}
