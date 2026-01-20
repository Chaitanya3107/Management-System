package com.example.ManagementSystem.Service;

import com.example.ManagementSystem.Entity.Parts;
import com.example.ManagementSystem.Repository.PartsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PartsServiceTest {
    @Mock
    PartsRepository partsRepository;
    @InjectMocks
    PartsService partsService;

    @Test
    void addPartsShouldAddPartsSuccessfully(){
        Parts part = new Parts();
        part.setId(1L);
        part.setName("Headlight");
        part.setStockQuantity(10);
        part.setSellingPrice(BigDecimal.valueOf(500.00));

        Mockito.when(partsRepository.save(part)).thenReturn(part);
        Parts addedPart = partsService.addParts(part);

        Assertions.assertEquals(part.getName(),addedPart.getName());
        Mockito.verify(partsRepository,Mockito.times(1)).save(part);

    }
    @Test
    void addPartsShouldThrowRuntimeExceptionForInvalidPartName(){
        Parts part = new Parts();
        part.setId(1L);
        part.setName("");
        part.setStockQuantity(10);
        part.setSellingPrice(BigDecimal.valueOf(500.00));
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> partsService.addParts(part));
        Assertions.assertEquals("Part name is invalid",exception.getMessage());
        Mockito.verify(partsRepository,Mockito.never()).save(part); // checking that save method is not called

    }

    // test for a private method
    @Test
    void testPrivateMethod_validatePartName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // using Java Reflections to use private methods
        Method validatePartName = PartsService.class.getDeclaredMethod("validatePartName", String.class);
        validatePartName.setAccessible(true);
        Boolean headlight = (Boolean) validatePartName.invoke(partsService, "Headlight");
        assertTrue(headlight);
    }
    @Test
    void testPrivateMethod_validatePartNameIfNameIsInvalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // using Java Reflections to use private methods
        Method validatePartName = PartsService.class.getDeclaredMethod("validatePartName", String.class);
        validatePartName.setAccessible(true);
        Boolean headlight = (Boolean) validatePartName.invoke(partsService, "");
        assertFalse(headlight);
    }

    @Test
    void getPartByIdShouldSuccessfullyGetPartById(){
        Parts part = new Parts();
        part.setId(1L);
        part.setName("Headlight");
        part.setStockQuantity(10);
        part.setSellingPrice(BigDecimal.valueOf(500.00));
        Mockito.when(partsRepository.findById(part.getId())).thenReturn(Optional.of(part));
        Parts fetchedPart = partsService.getPartById(part.getId());

        Assertions.assertEquals(part.getName(),fetchedPart.getName());

    }

    @Test
    void deletePartShouldDeletePartSuccessfully(){
        Mockito.doNothing().when(partsRepository).deleteById(1L);
        partsService.deletePart(1L);
        Mockito.verify(partsRepository,Mockito.times(1)).deleteById(1L);
    }

}










