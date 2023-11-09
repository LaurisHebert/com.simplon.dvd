package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.services.DvdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DvdControllerTest {

    @Mock
    private DvdMapper dvdMapper;
    @Mock
    private DvdService service;
    @InjectMocks
    private DvdController underTest;

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Nested
    class WhenSaving {
        @Mock
        private DvdDTO dvdDTO;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenFindingAll {
        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenFindingById {
        private final int ID = 92;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenUpdating {
        private final int ID = 45;
        @Mock
        private DvdDTO dvdDTO;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenDeletingById {
        private final int ID = 44;

        @BeforeEach
        void setup() {
        }
    }
}