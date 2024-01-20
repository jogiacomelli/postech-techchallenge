package br.com.postech.techchallenge.adapters.mappers;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import br.com.postech.techchallenge.application.dto.ComboDTO;
import br.com.postech.techchallenge.domain.model.Combo;
import br.com.postech.techchallenge.external.infrastructure.dataBaseEntities.ComboEntity;

@Component
public class ComboMapper {
    private final ProdutoMapper produtoMapper;
    public ComboMapper(ProdutoMapper produtoMapper){
        this.produtoMapper = produtoMapper;
    }

    public ComboEntity domainToEntity(Combo combo) {
        if (combo == null) {
            return null;
        }

        ComboEntity comboEntity = new ComboEntity();
        comboEntity.setId(combo.getId());
        comboEntity.setLanche(produtoMapper.domainToEntity(combo.getLanche()));
        comboEntity.setAcompanhamento(produtoMapper.domainToEntity(combo.getAcompanhamento()));
        comboEntity.setBebida(produtoMapper.domainToEntity(combo.getBebida()));
        comboEntity.setSobremesa(produtoMapper.domainToEntity(combo.getSobremesa()));
        comboEntity.setQuantidade(combo.getQuantidade());
        comboEntity.setValorUnitario(combo.getValorUnitario());
        comboEntity.setValorTotal(combo.getValorTotal());

        return comboEntity;
    }

    public Combo dtoToDomain(ComboDTO comboDTO) {
        if(comboDTO == null) {
            return null;
        }

        Combo combo = new Combo();
        combo.setLanche(produtoMapper.dtoToDomain(comboDTO.lanche()));
        combo.setAcompanhamento(produtoMapper.dtoToDomain(comboDTO.acompanhamento()));
        combo.setBebida(produtoMapper.dtoToDomain(comboDTO.bebida()));
        combo.setSobremesa(produtoMapper.dtoToDomain(comboDTO.sobremesa()));
        combo.setQuantidade(comboDTO.quantidade());
        combo.setValorUnitario(comboDTO.valorUnitario());
        combo.setValorTotal(comboDTO.valorTotal());

        return combo;
    }

    public ComboDTO domainToDto(Combo combo) {
        if (combo == null) {
            return null;
        }

        return new ComboDTO(combo.getId(),
                produtoMapper.domainToDto(combo.getLanche()),
                produtoMapper.domainToDto(combo.getAcompanhamento()),
                produtoMapper.domainToDto(combo.getBebida()),
                produtoMapper.domainToDto(combo.getSobremesa()),
                combo.getQuantidade(),
                combo.getValorUnitario(),
                combo.getValorTotal());

    }

    public Combo entityToDomain(ComboEntity comboEntity) {
        if (comboEntity == null) {
            return null;
        }

        Combo combo = new Combo();
        combo.setId(comboEntity.getId());
        combo.setLanche(produtoMapper.entityToDomain(comboEntity.getLanche()));
        combo.setAcompanhamento(produtoMapper.entityToDomain(comboEntity.getAcompanhamento()));
        combo.setBebida(produtoMapper.entityToDomain(comboEntity.getBebida()));
        combo.setSobremesa(produtoMapper.entityToDomain(comboEntity.getSobremesa()));
        combo.setQuantidade(comboEntity.getQuantidade());
        combo.setValorUnitario(comboEntity.getValorUnitario());
        combo.setValorTotal(comboEntity.getValorTotal());

        return combo;
    }
}
