package com.melisa.Issuemanagement.service.impl;

import com.melisa.Issuemanagement.dto.ProjectDto;
import com.melisa.Issuemanagement.entity.Project;
import com.melisa.Issuemanagement.repository.ProjectRepository;
import com.melisa.Issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }


    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);

    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null) {
            throw new IllegalArgumentException("Project Does Not Exist ID: " + id);
        }
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null && projectCheck.getId() != projectDb.getId()) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }

}
